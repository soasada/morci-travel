import {createLocalVue, mount, shallowMount} from '@vue/test-utils';
import Vuex from 'vuex';
import i18n from '@/plugins/i18n';
import {library} from '@fortawesome/fontawesome-svg-core';
import testStore from './testStore';
import {
    faArrowAltCircleLeft,
    faArrowAltCircleRight,
    faCalendarDay,
    faCalendarWeek,
    faMapSigns,
    faUser
} from '@fortawesome/free-solid-svg-icons';
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome';

library.add(
    faArrowAltCircleLeft,
    faArrowAltCircleRight,
    faCalendarDay,
    faCalendarWeek,
    faMapSigns,
    faUser
);

const localVue = createLocalVue();

localVue.use(Vuex);

export default {
    shallow(component, props = {}) {
        return shallowMount(component, {
            localVue: localVue,
            store: testStore,
            mocks: {
                $t: key => i18n.messages.en[key]
            },
            stubs: {
                'font-awesome-icon': FontAwesomeIcon
            },
            propsData: props
        });
    },

    mount(component, props = {}) {
        return mount(component, {
            localVue: localVue,
            store: testStore,
            mocks: {
                $t: key => i18n.messages.en[key]
            },
            stubs: {
                'font-awesome-icon': FontAwesomeIcon
            },
            propsData: props
        });
    },

    labelText(wrapper, key) {
        return wrapper.find("label[for='" + key + "']").text();
    },

    lastEmitted(wrapper, eventId) {
        let emittedElements = wrapper.emitted()[eventId];
        return emittedElements[emittedElements.length - 1][0];
    }
};