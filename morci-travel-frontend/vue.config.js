module.exports = {
    devServer: {
        proxy: {
            '/v1': {
                target: 'http://localhost:8082',
                ws: true,
                changeOrigin: true
            }
        }
    },
    outputDir: 'target/dist',
    assetsDir: 'static'
};