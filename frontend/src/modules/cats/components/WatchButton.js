import React, {useState} from "react";
import {Button, DatePicker, Form, Input, Modal,Select} from "antd";
import moment from "moment";

const {Item} = Form;
const {TextArea} = Input;
const {Option} = Select;
export const WatchButton = ({cat}) =>{
    const [visible, setVisible] = useState(false);
    const [visible2, setVisible2] = useState(false);
    const [form] = Form.useForm();
    const [form2] = Form.useForm();

    const showModal = () => setVisible(true);
    const handleCancel = () => setVisible(false);
    const handleShelter = (values) => {
        console.log(values);
        setVisible2(true);
    }
    const handleShelterCancel = () => setVisible2(false);
    const handleEdit = (values) => {
        console.log(values);
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
                onOk={handleShelter}
                onCancel={handleCancel}
            >
                <div >
                    <Form form={form} initialValues={{...cat, appearance_date: moment(cat.appearance_date)}}  onFinish={handleEdit}  >
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
                            <Select defaultValue={cat.breed}>
                                <Option value="синий ушастик">синий ушастик</Option>
                                <Option value="jack">Jack</Option>
                                <Option value="lucy">Lucy</Option>
                                <Option value="tom">Tom</Option>
                            </Select>
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
                            <Select>
                                <Option value="jack">Jack</Option>
                                <Option value="lucy">Lucy</Option>
                                <Option value="tom">Tom</Option>
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