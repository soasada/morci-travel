import InputDate from '@/components/forms/InputDate';
import common from './../../common';

function getProps(label) {
    return {
        value: '',
        label: label,
        text: 'TEST_TEXT',
        icon: 'user'
    };
}

describe('InputDate.vue', () => {
    const propsWrapper = common.mount(InputDate, getProps('TEST'));

    it('Should emit input with the date', async () => {
        propsWrapper.find('#TEST').setValue('1992-09-19');
        await propsWrapper.vm.$nextTick();
        const inputDate = common.lastEmitted(propsWrapper, 'input');

        expect(inputDate).toEqual('1992-09-19');
    });
});
