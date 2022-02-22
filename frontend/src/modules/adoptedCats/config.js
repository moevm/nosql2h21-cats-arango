import {WatchButton} from "./components/WatchButton";
import moment from "moment";

export const COLUMNS = [
    {
        title: 'Кличка',
        dataIndex: 'name',
        key: 'title',
    },
    {
        title: 'Возраст',
        dataIndex: 'age',
        align: 'center',
    },
    {
        title: 'Вес',
        dataIndex: 'weight',
        align: 'center',
    },
    {
        title: 'Дата появления в приюте',
        dataIndex: 'appearance_date',
        align: 'center',
        render:(record) => <h1>{moment(record.appearance_date).format("DD/MM/YYYY")}</h1>,
    },
    {
        title: 'Порода',
        dataIndex: 'breed',
        align: 'center',

    },
    {
        title: 'Владелец',
        dataIndex: 'ownerName',
        align: 'center',

    },
    {
        title: 'Действие',
        key: 'actions',
        align: 'center',
        render: (record) => (
            <WatchButton adoptedCat={record} />
        ),
    },
];