import React, {useEffect, useState} from "react";
import {Button, DatePicker, Form, Input, Modal, Table} from "antd";
import './CatsTable.css'
import {addCat, getCats} from "../actions";
import {COLUMNS} from "../config";
import moment from "moment";

const dataSource = [
    {
        key: '1',
        name: 'Mike',
        age: '10 лет',
        weight: '32кг',
        appearance_date: '2022-01-12T18:00:42.305Z',
        breed:'синий ушастик',
        description: 'твой самый лучший друг'
    },
];

const {Item} = Form;
const {TextArea} = Input;

export const CatsTable = () =>{
    const [data, setData] = useState();
    const [visible, setVisible] = useState(false);
    const [form] = Form.useForm();


    useEffect(()=>{
        (async ()=>{
            try{
                const cats = await getCats();
                setData(cats);
            }catch (e) {
                console.error(e, 'наташа, мы все уронили');
                setData(dataSource);
            }

        })()
    },[])

    const showModal = () => setVisible(true);
    const handleCancel = () => setVisible(false);
    const handleCreate = async (values) => {
        try{
            // console.log({data:{...values, appearance_date:values.appearance_date.format()}})
            const cats = await addCat({...values, appearance_date:values.appearance_date.format()});
            console.log(cats);
        }catch (e) {
            console.error(e, 'наташа, мы все уронили')
        }
        const cats = await getCats();
        setData(cats);
        setVisible(false);
    }

    return (
        <>
            <header className={'.CatsTable_header'} style={{display: 'flex', flexDirection: 'row', margin: '20px 0'}}>
                <h1>Коты в приюте</h1>
                <Button style={{marginLeft: 'auto'}} onClick={showModal}>Добавить</Button>
            </header>

            <Table
                rowKey='id'
                columns={COLUMNS}
                dataSource={data}
                bordered
            />

            <Modal
                title={'Добавление котенка'}
                visible={visible}
                cancelText='Отмена'
                okText='Добавить'
                onOk={handleCancel}
                onCancel={handleCancel}
                footer={<></>}
            >
                    <Form form={form} onFinish={handleCreate} >
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
                            <DatePicker format={'DD.MM.YYYY'} style={{color: 'black'}}/>
                        </Item>
                        <Item name='breed' label="Порода" >
                            <Input />
                        </Item>
                        <Item name='description' label="Описание">
                            <TextArea rows={5} />
                        </Item>
                        <Item >
                            <Button type="primary" htmlType="submit">
                                Добавить
                            </Button>
                        </Item>
                    </Form>

            </Modal>

        </>
    );
}