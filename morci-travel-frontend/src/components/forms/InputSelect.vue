<template>
    <div class="col-md-2">
        <label :for="name">{{ text }}</label>
        <div class="input-group input-group-sm">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <font-awesome-icon :icon="['fas', icon]"/>
                </div>
            </div>
            <select :id="name" class="form-control" v-model="selectedValue" @change="onInput">
                <option v-for="(item, index) in options" :key="item.text + index" :value="item.value">
                    {{item.text}}
                </option>
            </select>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'InputSelect',
        props: {
            name: {
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
                selectedValue: ''
            };
        },
        methods: {
            onInput(event) {
                this.value = event.target.value;
                this.$emit('on-change-select', this.selectedValue);
            }
        }
    }
</script>

<style scoped>

</style>