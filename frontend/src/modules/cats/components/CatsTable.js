import React, {useEffect, useState} from "react";
import {Table, Button, Form, Input, Modal} from "antd";
import './CatsTable.css'
import {getCats} from "../actions";
import {COLUMNS} from "../config";

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
    const [data, setData] = useState(undefined);
    const [visible, setVisible] = useState(false);
    const [form] = Form.useForm();


    // useEffect(()=>{
    //     (async ()=>{
    //         try{
    //             const cats = await getCats();
    //             setData(cats);
    //         }catch (e) {
    //             console.error(e, 'наташа, мы все уронили')
    //         }
    //
    //     })()
    // },[])

    const showModal = () => setVisible(true);
    const handleCancel = () => setVisible(false);
    const handleCreate = (values) => {
        console.log(values);
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
                dataSource={dataSource}
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
                            <Input />
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