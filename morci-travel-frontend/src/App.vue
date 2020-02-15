<template>
    <div id="app">
        <MtHeader/>
        <router-view/>
        <MtFooter/>
    </div>
</template>

<script>
    import MtHeader from '@/components/MtHeader';
    import MtFooter from '@/components/MtFooter';

    export default {
        name: 'App',
        components: {
            MtHeader,
            MtFooter
        }
    };
</script>

<style lang="scss">

</style>
