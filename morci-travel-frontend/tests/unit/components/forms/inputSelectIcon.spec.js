import InputSelectIcon from '@/components/forms/InputSelectIcon';
import common from './../../common';

function getProps(label) {
    return {
        value: '',
        label: label,
        text: 'TEST_TEXT',
        icon: 'user',
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

describe('InputSelectIcon.vue', () => {
    const propsWrapper = common.mount(InputSelectIcon, getProps('TEST'));

    it('Should render label text', () => {
        expect(common.labelText(propsWrapper, 'TEST')).toBe('TEST_TEXT');
    });

    it('Should render icon', () => {
        expect(propsWrapper.find('.fa-user').exists()).toBe(true);
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
