import {mount, shallowMount} from '@vue/test-utils';
import i18n from '@/plugins/i18n';
import {library} from '@fortawesome/fontawesome-svg-core';
import testingStore from './testingStore';
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

export default {
    shallow(component, props = {}) {
        return shallowMount(component, {
            localVue: testingStore.localVue,
            store: testingStore.testStore,
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
            localVue: testingStore.localVue,
            store: testingStore.testStore,
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