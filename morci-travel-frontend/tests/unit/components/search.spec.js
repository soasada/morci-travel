import {shallowMount} from '@vue/test-utils';
import SearchEngine from '@/components/SearchEngine.vue';

describe('SearchEngine.vue', () => {


    it('renders props.msg when passed', () => {
        const msg = 'new message';
        const wrapper = shallowMount(HelloWorld, {
            propsData: {msg}
        });
        expect(wrapper.text()).toMatch(msg);
    });
});
