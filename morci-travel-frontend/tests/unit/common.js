import {shallowMount} from '@vue/test-utils';
import i18n from '@/plugins/i18n';

export default {
    factory(component) {
        return shallowMount(component, {
            mocks: {
                $t: key => i18n.messages.en[key]
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