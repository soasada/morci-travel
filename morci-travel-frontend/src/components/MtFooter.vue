<template>
    <footer class="container-fluid">
        <div class="row">
            <div class="col-sm">
                <img alt="Morci Travel logo footer" src="../assets/logo.svg" width="120" height="120"
                     class="d-inline-block align-top">
            </div>
            <div class="col-sm">
                <router-link exact :to="{ name: 'about' }">
                    About
                </router-link>
            </div>
            <div class="col-sm">
                <p class="font-weight-bold">Spring Boot + Vue.js demo app BUILD: {{version}}</p>
                <p class="font-weight-normal">by <a href="https://github.com/soasada">Nicolás Vargas Ortega</a>.</p>
                <p class="font-weight-normal">The source code is licensed <a
                        href="http://opensource.org/licenses/mit-license.php">MIT</a>. © {{ new Date().getFullYear() }}
                    Popokis.com</p>
            </div>
        </div>
    </footer>
</template>

<script>
    import http from '@/http';

    export default {
        name: 'MtFooter',
        data() {
            return {
                version: undefined
            };
        },
        mounted() {
            const self = this;
            http.get('/app/version').then(response => {
                response.json().then(version => {
                    self.version = version.version;
                });
            });
        }
    };
</script>

<style scoped>

</style>