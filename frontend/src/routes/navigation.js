import {CatsRouter} from "../modules/cats/cats-router";

export const router = [
  {
    name: 'Коты в  приюте',
    path: '/cats',
    component: CatsRouter,
    disabled: false,
  },
];
