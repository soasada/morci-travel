<template>
    <div>
        <label :for="label" class="sr-only">{{ text }}</label>
        <div class="input-group input-group-sm">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <font-awesome-icon :icon="['fas', icon]"/>
                </div>
            </div>
            <Select v-model="selectValue" :id="label" :options="options" @input="$emit('input', selectValue)"/>
        </div>
    </div>
</template>

<script>
    import Select from '@/components/forms/Select';

    export default {
        name: 'InputSelectIcon',
        components: {
            Select
        },
        props: {
            value: {
                required: true
            },
            label: {
                type: String,
                required: true
            },
            text: {
                type: String,
                required: true
            },
            icon: {
                type: String,
                required: false
            },
            options: {
                type: Array,
                required: true
            }
        },
        data() {
            return {
                selectValue: undefined
            };
        }
    }
</script>

<style scoped>

</style>