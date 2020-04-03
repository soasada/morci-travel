<template>
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <router-link class="navbar-brand" :to="{ name: 'home' }">
                <img alt="Morci Travel logo" src="../assets/logo.svg" width="30" height="30"
                     class="d-inline-block align-top">
                morcitravel
            </router-link>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <router-link class="nav-link" active-class="active" exact :to="{ name: 'about' }">
                        About
                    </router-link>
                </li>
                <li class="nav-item dropdown">
                    <select class="custom-select custom-select-sm d-block w-100" v-model="$i18n.locale">
                        <option v-for="(lang, i) in $i18n.messages" :key="`Lang${i}`" :value="i">{{ i }}</option>
                    </select>
                </li>
            </ul>
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