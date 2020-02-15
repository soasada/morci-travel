<template>
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
            <router-link class="navbar-brand" :to="{ name: 'home' }">
                <img alt="Morci Travel logo" src="../assets/logo.svg" width="30" height="30"
                     class="d-inline-block align-top">
                morcitravel
            </router-link>

        </div>
    </nav>
</template>

<script>
    export default {
        name: 'MtHeader'
    }
</script>

<style scoped>

</style>