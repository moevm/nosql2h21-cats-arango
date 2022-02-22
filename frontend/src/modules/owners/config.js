import {WatchButton} from "./components/WatchButton";
import moment from "moment";

export const COLUMNS = [
    {
        title: 'Полное имя',
        dataIndex: 'full_name',
        key: 'title',
    },
    {
        title: 'Паспорт',
        dataIndex: 'document',
        align: 'center',
    },
    {
        title: 'Телефон',
        dataIndex: 'phone',
        align: 'center',
    },
    {
        title: 'Дата рождения',
        dataIndex: 'birth_date',
        align: 'center',
        render:(record) => <h1>{moment(record.appearance_date).format("DD/MM/YYYY")}</h1>,
    },
    {
        title: 'Действие',
        key: 'actions',
        align: 'center',
        render: (record) => (
                <WatchButton owner={record} />
        ),
    },
];