import Vue from 'vue'
import SearchEngine from '@/components/SearchEngine.vue';
import common from './../common';

describe('SearchEngine.vue', () => {
    it('Should render the journey type select', () => {
        const wrapper = common.shallow(SearchEngine);
        expect(wrapper.find('#inputJourneyType').exists()).toBe(true);
    });

    it('Should hide return date input when oneway is selected', async () => {
        const wrapper = common.shallow(SearchEngine);
        wrapper.find('#inputJourneyType').findAll('option').at(0).setSelected();
        await Vue.nextTick();
        expect(wrapper.find('#inputReturnDate').isVisible()).toBe(false);
    });

    it('Should show return date input when roundtrip is selected', async () => {
        const wrapper = common.shallow(SearchEngine);
        wrapper.find('#inputJourneyType').findAll('option').at(1).setSelected();
        await Vue.nextTick();
        expect(wrapper.find('#inputReturnDate').isVisible()).toBe(true);
    });
});
