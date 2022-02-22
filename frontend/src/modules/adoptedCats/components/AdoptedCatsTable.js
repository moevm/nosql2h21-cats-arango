import React, {useEffect, useState} from "react";
import {Table} from "antd";
import './AdoptedCatsTable.css'
import {COLUMNS} from "../config";

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
    const [data, setData] = useState(undefined);

    // useEffect(()=>{
    //     (async ()=>{
    //         try{
    //             const cats = await getAdoptedCats();
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
                <h1>Коты которых приютили</h1>
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