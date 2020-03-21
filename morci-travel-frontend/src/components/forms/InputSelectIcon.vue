<template>
    <div>
        <label :for="label" class="sr-only">{{ text }}</label>
        <div class="input-group input-group-sm">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <font-awesome-icon :icon="['fas', icon]"/>
                </div>
            </div>
            <InputSelect :id="label" />
        </div>
    </div>
</template>

<script>
    import InputSelect from '@/components/forms/InputSelect';

    export default {
        name: 'InputSelect',
        components: {
            InputSelect
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
        }
    }
</script>

<style scoped>

</style>