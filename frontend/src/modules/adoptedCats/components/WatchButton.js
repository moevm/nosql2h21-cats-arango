import React, {useState} from "react";
import {Button, Form, Input, Modal} from "antd";

const {Item} = Form;
const {TextArea} = Input;
export const WatchButton = ({adoptedCat}) =>{
    const [visible, setVisible] = useState(false);
    const [form] = Form.useForm();

    const showModal = () => setVisible(true);
    const handleCancel = () => setVisible(false);
    return(
        <>
            <Button type='primary' onClick={showModal}>Смотреть</Button>

            <Modal
                title={'Кот которого приютили'}
                visible={visible}
                // cancelText='Назад'
                // okText='Сохранить'
                // onOk={handleCancel}
                onCancel={handleCancel}
                footer ={<></>}
            >
                <div >
                    <Form form={form} component={false} initialValues={{...adoptedCat} } >
                        <Item name='name' label="Кличка" >
                            <Input disabled style={{color: 'black'}}/>
                        </Item>
                        <Item name='age' label="Возраст" >
                            <Input disabled style={{color: 'black'}}/>
                        </Item>
                        <Item name='weight' label="Вес" >
                            <Input disabled style={{color: 'black'}}/>
                        </Item>
                        <Item name='appearance_date' label="Дата появления в приюте">
                            <Input disabled style={{color: 'black'}}/>
                        </Item>
                        <Item name='breed' label="Порода" >
                            <Input disabled style={{color: 'black'}}/>
                        </Item>
                        <Item name='ownerName' label="Владелец" >
                            <Input disabled style={{color: 'black'}}/>
                        </Item>
                        <Item name='description' label="Описание">
                            <TextArea rows={5} disabled style={{color: 'black'}}/>
                        </Item>
                    </Form>
                </div>

            </Modal>
        </>
    )
}