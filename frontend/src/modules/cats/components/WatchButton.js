import React, {useState} from "react";
import { useForm } from 'antd/es/form/Form';
import {Button, Form, Input, Modal} from "antd";

const {Item} = Form;
const {TextArea} = Input;
export const WatchButton = () =>{
    const [visible, setVisible] = useState(false);
    const [visible2, setVisible2] = useState(false);
    const [form] = useForm();

    const showModal = () => setVisible(true);
    const handleCancel = () => setVisible(false);
    const handleShelter = () => setVisible2(true);
    const handleShelterCancel = () => setVisible2(false);

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
                    <Form form={form} component={false} >
                        <Item name='text' label="Кличка" >
                            <Input />
                        </Item>
                        <Item name='text' label="Возраст" >
                            <Input />
                        </Item>
                        <Item name='text' label="Вес" >
                            <Input />
                        </Item>
                        <Item name='text' label="Дата появления в приюте">
                            <Input />
                        </Item>
                        <Item name='text' label="Порода" >
                            <Input />
                        </Item>
                        <Item name='text' label="Описание">
                            <TextArea rows={5} />
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
            >
                <div >
                    <Form form={form} component={false} >
                        <Item name='text' label="Владелец">
                            <Input />
                        </Item>
                    </Form>
                </div>

            </Modal>
        </>
    )
}