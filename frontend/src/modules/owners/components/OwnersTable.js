import React, {useEffect, useState} from "react";
import {Button, DatePicker, Form, Input, Modal, Table} from "antd";
import './OwnersTable.css'
import {COLUMNS} from "../config";
import moment from "moment";

const dataSource = [
    {
        key: '1',
        full_name: 'Аввакумов Ибрагим',
        document: '4432 456434',
        birth_date: '1922-01-12T18:00:42.305Z',
    },
];
const {Item} = Form;

export const OwnersTable = () =>{
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
                <h1>Владельцы</h1>
                <Button style={{marginLeft: 'auto'}} onClick={showModal}>Добавить</Button>
            </header>

            <Table
                rowKey='id'
                columns={COLUMNS}
                dataSource={dataSource}
                bordered
            />

            <Modal
                title={'Добавление владельца'}
                visible={visible}
                cancelText='Отмена'
                okText='Добавить'
                onOk={handleCancel}
                onCancel={handleCancel}
                footer={<></>}
            >
                <Form form={form} onFinish={handleCreate} >
                    <Item name='full_name' label="Полное имя" >
                        <Input  />
                    </Item>
                    <Item name='document' label="Паспорт" >
                        <Input />
                    </Item>
                    <Item name='birth_date' label="Дата рождения" >
                        <DatePicker format={'DD.MM.YYYY'} defaultValue={moment()}  />
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