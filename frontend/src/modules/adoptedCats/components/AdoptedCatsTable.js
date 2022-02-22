import React, {useEffect, useState} from "react";
import {Table} from "antd";
import './AdoptedCatsTable.css'
import {COLUMNS} from "../config";
import {getAdoptedCats} from "../actions";

const dataSource = [
    {
        key: '1',
        name: 'Mike',
        age: '10 лет',
        weight: '32кг',
        appearance_date: '2022-01-12T18:00:42.305Z',
        breed:'синий ушастик',
        description: 'твой самый лучший друг',
        owner: 'Аввакумов Ибрагим',
        document: '4432 456434',
    },
];

export const AdoptedCatsTable = () =>{
    const [data, setData] = useState();

    useEffect(()=>{
        (async ()=>{
            try{
                const cats = await getAdoptedCats();
                setData(cats);
            }catch (e) {
                console.error(e, 'наташа, мы все уронили');
                setData(dataSource);
            }

        })()
    },[])

    return (
        <>
            <header className={'.CatsTable_header'} style={{display: 'flex', flexDirection: 'row', margin: '20px 0'}}>
                <h1>Коты которых приютили</h1>
            </header>

            <Table
                rowKey='id'
                columns={COLUMNS}
                dataSource={data}
                bordered
            />

        </>
    );
}