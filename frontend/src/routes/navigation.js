import {CatsRouter} from "../modules/cats/cats-router";
import {OwnersRouter} from "../modules/owners/owners-router";
import {AdoptedCatsRouter} from "../modules/adoptedCats/adopted-cats-router";

export const router = [
  {
    name: 'Коты в  приюте',
    path: '/cats',
    component: CatsRouter,
    disabled: false,
  },
  {
    name: 'Владельцы',
    path: '/owners',
    component: OwnersRouter,
    disabled: false,
  },
  {
    name: 'Котики которых приютили',
    path: '/adoptedCats',
    component: AdoptedCatsRouter,
    disabled: false,
  },
];
