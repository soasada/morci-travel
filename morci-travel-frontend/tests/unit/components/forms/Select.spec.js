import Select from '@/components/forms/Select.vue';
import common from './../../common';

function getProps(id) {
    return {
        value: '',
        id: id,
        options: [
            {
                value: 'Test1',
                text: 'TEST_TEXT1'
            },
            {
                value: 'Test2',
                text: 'TEST_TEXT2'
            }
        ]
    };
}

describe('Select.vue', () => {
    const propsWrapper = common.shallow(Select, getProps('TEST'));

    it('Should render id', () => {
        expect(propsWrapper.find('#TEST').exists()).toBe(true);
    });

    it('Should render the select with all options', () => {
        expect(propsWrapper.find("#TEST option[value='Test1']").exists()).toBe(true);
        expect(propsWrapper.find("#TEST").findAll('option').at(0).text()).toBe('TEST_TEXT1');
        expect(propsWrapper.find("#TEST option[value='Test2']").exists()).toBe(true);
        expect(propsWrapper.find("#TEST").findAll('option').at(1).text()).toBe('TEST_TEXT2');
    });

    it('Should emit input with selected value', async () => {
        propsWrapper.find('#TEST').findAll('option').at(1).setSelected();
        await propsWrapper.vm.$nextTick();
        const selectedValue = common.lastEmitted(propsWrapper, 'input');
        expect(selectedValue).toEqual('Test2');
        propsWrapper.find('#TEST').findAll('option').at(0).setSelected();
        await propsWrapper.vm.$nextTick();
        const selectedValue2 = common.lastEmitted(propsWrapper, 'input');
        expect(selectedValue2).toEqual('Test1');
    });
});
