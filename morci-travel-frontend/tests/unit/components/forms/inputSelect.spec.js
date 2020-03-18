import InputSelect from '@/components/forms/InputSelect.vue';
import common from './../../common';

function getProps(name, text, icon = '') {
    return {
        name: name,
        text: text,
        icon: icon,
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

describe('InputSelect.vue', () => {
    const propsWrapper = common.shallow(InputSelect, getProps('TEST', 'TEST_TEXT', 'user'));

    it('Should render name and text', () => {
        expect(propsWrapper.find('#TEST').exists()).toBe(true);
        expect(common.labelText(propsWrapper, 'TEST')).toMatch('TEST_TEXT');
    });

    it('Should render icon', () => {
        expect(propsWrapper.find('.fa-user').exists()).toBe(true);
    });

    it('Should render the select with all options', () => {
        expect(propsWrapper.find("#TEST option[value='Test1']").exists()).toBe(true);
        expect(propsWrapper.find("#TEST").findAll('option').at(0).text()).toBe('TEST_TEXT1');
        expect(propsWrapper.find("#TEST option[value='Test2']").exists()).toBe(true);
        expect(propsWrapper.find("#TEST").findAll('option').at(1).text()).toBe('TEST_TEXT2');
    });

    it('Should emit on-change-select with selected value', async () => {
        propsWrapper.find('#TEST').findAll('option').at(1).setSelected();
        await propsWrapper.vm.$nextTick();
        const selectedValue = common.lastEmitted(propsWrapper, 'on-change-select');
        expect(selectedValue).toEqual('Test2');
        propsWrapper.find('#TEST').findAll('option').at(0).setSelected();
        await propsWrapper.vm.$nextTick();
        const selectedValue2 = common.lastEmitted(propsWrapper, 'on-change-select');
        expect(selectedValue2).toEqual('Test1');
    });
});
