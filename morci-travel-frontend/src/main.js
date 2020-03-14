import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import i18n from './plugins/i18n';
import 'bootstrap/dist/css/bootstrap.min.css';
import {library} from '@fortawesome/fontawesome-svg-core';
import {
    faMapSigns,
    faUser,
    faArrowAltCircleRight,
    faArrowAltCircleLeft,
    faCalendarWeek,
    faCalendarDay
} from '@fortawesome/free-solid-svg-icons';
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome';

library.add(
    faMapSigns,
    faUser,
    faArrowAltCircleRight,
    faArrowAltCircleLeft,
    faCalendarWeek,
    faCalendarDay
);

Vue.component('font-awesome-icon', FontAwesomeIcon);

Vue.config.productionTip = false;

new Vue({
    router,
    store,
    i18n,
    render: h => h(App)
}).$mount('#app');
