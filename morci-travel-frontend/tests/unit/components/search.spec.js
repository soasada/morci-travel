import SearchEngine from '@/components/SearchEngine.vue';
import common from './../common';

describe('SearchEngine.vue', () => {
    it('Should render the journey type select', () => {
        const wrapper = common.factory(SearchEngine);
        expect(wrapper.find('.mt-search-journey-type').exists()).toBe(true);
    });
});
