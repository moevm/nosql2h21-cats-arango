import React, {useEffect, useState} from "react";
import {Table} from "antd";
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

export const CatsTable = () =>{
    const [data, setData] = useState(undefined);

    useEffect(()=>{
        (async ()=>{
            try{
                const cats = await getCats();
                setData(cats);
            }catch (e) {
                console.error(e, 'наташа, мы все уронили')
            }

        })()
    },[])

    return (
        <>
            <header className={'.CatsTable_header'}>
                <h1>Комментарии</h1>
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