import Vue from 'vue';
import Vuex from 'vuex';
import http from '@/http';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        searching: false,
        searchResult: []
    },
    mutations: {
        SET_SEARCHING(state, searching) {
            state.searching = searching;
        },
        PUSH_SEARCH_RESULT(state, result) {
            state.searchResult.push(result);
        },
        RESET_SEARCH_RESULT(state) {
            state.searchResult = [];
        }
    },
    actions: {
        search({commit, state}, searchRequest) {
            if (!state.searching) {
                commit('SET_SEARCHING', true);
                commit('RESET_SEARCH_RESULT');
                http.post('/search', searchRequest).then(response => {
                    response.json().then(searchId => {
                        let eventSource = new EventSource(`/v1/search/${searchId}/push`);

                        eventSource.onerror = () => {
                            eventSource.close();
                            commit('SET_SEARCHING', false);
                        };

                        eventSource.addEventListener('search-result', (e) => {
                            commit('PUSH_SEARCH_RESULT', e.data);
                        }, false);
                    });
                });
            }
        }
    }
});
