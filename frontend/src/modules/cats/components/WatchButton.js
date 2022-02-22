import React, {useEffect, useState} from "react";
import {Button, DatePicker, Form, Input, Modal, Select} from "antd";
import moment from "moment";
import {adoptCat, updateCat} from "../actions";
import {getOwners} from "../../owners/actions";

const {Item} = Form;
const {TextArea} = Input;
const {Option} = Select;
export const WatchButton = ({cat}) =>{
    const [visible, setVisible] = useState(false);
    const [visible2, setVisible2] = useState(false);
    const [owners, setOwners] = useState([{key: 'mas', owner:'anton'}]);

    useEffect(()=>{
        (async ()=>{
            try{
                const cats = await getOwners();
                setOwners(cats.map((owner)=>{return{key:owner.key, owner:owner.full_name}}));
            }catch (e) {
                console.error(e, 'наташа, мы все уронили')
            }

        })()
    },[])

    const [form] = Form.useForm();
    const [form2] = Form.useForm();

    const showModal = () => setVisible(true);
    const handleCancel = () => setVisible(false);
    const handleOpenShelterDialog = () => {
        setVisible2(true);
    }
    const handleShelter = async (values) => {
        try{
            const cats = await adoptCat({catKey: cat.key, ownerKey: values.owner.value});
            const hui = await updateCat({...cat, ownerName: values.owner.label});
            console.log(cats, hui);
        }catch (e) {
            console.error(e, 'наташа, мы все уронили')
        }
        console.log(cat, values)
        console.log({data:{catKey: cat.key, ownerKey: values.owner.label}});
    }
    const handleShelterCancel = () => setVisible2(false);
    const handleEdit = async (values) => {
        console.log(values);
        await updateCat(values)
        setVisible(false);
    }
    return(
        <>
            <Button type='primary' onClick={showModal}>Смотреть</Button>

            <Modal
                title={'Информация о котенке'}
                visible={visible}
                cancelText='Назад'
                okText='Приютить'
                onOk={handleOpenShelterDialog}
                onCancel={handleCancel}
            >
                <div >
                    <Form form={form} initialValues={{...cat, appearance_date: moment(cat.appearance_date)}}  onFinish={handleEdit}  >
                        <Item hidden name="key">
                            <Input type="hidden" />
                        </Item>
                        <Item name='name' label="Кличка" >
                            <Input />
                        </Item>
                        <Item name='age' label="Возраст" >
                            <Input />
                        </Item>
                        <Item name='weight' label="Вес" >
                            <Input />
                        </Item>
                        <Item name='appearance_date' label="Дата появления в приюте">
                            <DatePicker format={'DD.MM.YYYY'} defaultValue={moment()}/>
                        </Item>
                        <Item name='breed' label="Порода" >
                            <Input />
                        </Item>
                        <Item name='description' label="Описание">
                            <TextArea rows={5} />
                        </Item>
                        <Item >
                            <Button type="primary" htmlType="submit">
                                Редактировать
                            </Button>
                        </Item>
                    </Form>
                </div>

            </Modal>
            <Modal
                title={'Выбор владельца'}
                visible={visible2}
                cancelText='Назад'
                okText='Приютить'
                onOk={handleShelterCancel}
                onCancel={handleShelterCancel}
                footer={<></>}
            >
                <div >
                    <Form form={form2} onFinish={handleShelter} >
                        <Item name='owner' label="Владелец">
                            <Select labelInValue>
                                {owners.map((owner)=> <Option value={owner.key}>{owner.owner}</Option>)}
                            </Select>
                        </Item>
                        <Item >
                            <Button type="primary" htmlType="submit">
                                Приютить
                            </Button>
                        </Item>
                    </Form>
                </div>

            </Modal>
        </>
    )
}