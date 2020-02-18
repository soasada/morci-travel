import {shallowMount} from '@vue/test-utils';
import SearchEngine from '@/components/SearchEngine.vue';

describe('SearchEngine.vue', () => {
    const getShallow = (component, props = {}) => {
        return shallowMount(component, {
            propsData: props
        });
    };

    it('renders the journey type select', () => {
        const wrapper = getShallow(SearchEngine);
        expect(wrapper.find('.mt-search-journey-type').exists()).toBe(true);
    });
});
