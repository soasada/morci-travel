import {mount, shallowMount} from '@vue/test-utils';
import i18n from '@/plugins/i18n';
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";

export default {
    shallow(component) {
        return shallowMount(component, {
            mocks: {
                $t: key => i18n.messages.en[key]
            },
            stubs: {
                'font-awesome-icon': FontAwesomeIcon
            }
        });
    },

    mount(component) {
        return mount(component, {
            mocks: {
                $t: key => i18n.messages.en[key]
            },
            stubs: {
                'font-awesome-icon': FontAwesomeIcon
            }
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