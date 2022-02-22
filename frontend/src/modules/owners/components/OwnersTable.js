import React, {useEffect, useState} from "react";
import {Table} from "antd";
import './OwnersTable.css'
import {COLUMNS} from "../config";

const dataSource = [
    {
        key: '1',
        full_name: 'Аввакумов Ибрагим',
        document: '4432 456434',
        phone: '+7 993 444 44 21',
        birth_date: '1922-01-12T18:00:42.305Z',
    },
];

export const OwnersTable = () =>{
    const [data, setData] = useState(undefined);

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

    return (
        <>
            <header className={'.OwnersTable_header'}>
                <h1>Владельцы</h1>
            </header>

            <Table
                rowKey='id'
                columns={COLUMNS}
                dataSource={dataSource}
                bordered
            />

        </>
    );
}