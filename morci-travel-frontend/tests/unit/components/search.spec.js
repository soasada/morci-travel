import Vue from 'vue';
import SearchEngine from '@/components/SearchEngine';
import common from './../common';

describe('SearchEngine.vue', () => {
    const wrapper = common.mount(SearchEngine);

    it('Should render the journey type select', () => {
        expect(wrapper.find('#inputJourneyType').exists()).toBe(true);
    });

    it('Should hide return date input when oneway is selected', async () => {
        wrapper.find('#inputJourneyType').findAll('option').at(0).setSelected();
        await Vue.nextTick();
        expect(wrapper.find('#inputReturnDate').isVisible()).toBe(false);
    });

    it('Should show return date input when roundtrip is selected', async () => {
        wrapper.find('#inputJourneyType').findAll('option').at(1).setSelected();
        await Vue.nextTick();
        expect(wrapper.find('#inputReturnDate').isVisible()).toBe(true);
    });
});
