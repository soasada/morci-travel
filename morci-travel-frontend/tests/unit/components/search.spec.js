import SearchEngine from '@/components/SearchEngine.vue';
import common from './../common';

describe('SearchEngine.vue', () => {
    it('Should render the journey type select', () => {
        const wrapper = common.factory(SearchEngine);
        expect(wrapper.find('#inputJourneyType').exists()).toBe(true);
    });

    it('Should hide return date input when oneway is selected', () => {
        const wrapper = common.factory(SearchEngine);
        wrapper.find('#inputJourneyType').findAll('option').at(1).setSelected();
        expect(wrapper.find('#inputReturnDate').isVisible()).toBe(false);
    });
});
