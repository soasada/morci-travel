import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

function loadView(view) {
    return () => import(/* webpackChunkName: "view-[request]" */ `@/views/${view}.vue`);
}

const routes = [
    {
        path: '/',
        name: 'home',
        component: loadView('Home')
    },
    {
        path: '/about',
        name: 'about',
        component: loadView('About')
    }
];

const router = new VueRouter({
    routes
});

export default router;
