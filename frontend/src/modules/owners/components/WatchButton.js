import React, {useState} from "react";
import {Button, DatePicker, Form, Input, Modal} from "antd";
import moment from "moment";

const {Item} = Form;
export const WatchButton = ({owner}) =>{
    const [visible, setVisible] = useState(false);
    const [form] = Form.useForm();

    const showModal = () => setVisible(true);
    const handleCancel = () => setVisible(false);
    return(
        <>
            <Button type='primary' onClick={showModal}>Смотреть</Button>

            <Modal
                title={'Информация о владельце'}
                visible={visible}
                cancelText='Назад'
                okText='Сохранить'
                onOk={handleCancel}
                onCancel={handleCancel}
                footer ={<></>}
            >
                <div >
                    <Form form={form} component={false} initialValues={{...owner,birth_date: moment(owner.birth_date)} } >
                        <Item name='full_name' label="Полное имя" >
                            <Input disabled style={{color: 'black'}}/>
                        </Item>
                        <Item name='document' label="Паспорт" >
                            <Input disabled style={{color: 'black'}}/>
                        </Item>
                        <Item name='birth_date' label="Дата рождения" style={{color: 'black'}}>
                            <DatePicker format={'DD.MM.YYYY'} defaultValue={moment()} disabled style={{color: 'black'}}/>
                        </Item>
                    </Form>
                </div>

            </Modal>
        </>
    )
}