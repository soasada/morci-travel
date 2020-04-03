import Vuex from 'vuex';
import {createLocalVue} from '@vue/test-utils';

const localVue = createLocalVue();
localVue.use(Vuex);

const store = new Vuex.Store({
    state: {
        searching: false,
        searchResult: []
    },
    mutations: {},
    actions: {}
});

const testingStore = {
    localVue: localVue,
    testStore: store
};

export default testingStore;
