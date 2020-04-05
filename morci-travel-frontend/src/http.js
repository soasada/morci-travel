export default {
    get(resource) {
        return this.execute('GET', resource);
    },

    post(resource, data) {
        return this.execute('POST', resource, data);
    },

    put(resource, data) {
        return this.execute('PUT', resource, data);
    },

    delete(resource, id) {
        if (confirm('Are you sure? ID: ' + id)) {
            return this.execute('DELETE', resource + '/' + id);
        }
    },

    execute(method, resource, data = {}) {
        if (Object.keys(data).length === 0 && data.constructor === Object) {
            return fetch('/v1' + resource, {
                method: method,
                mode: 'cors',
                cache: 'no-cache',
                credentials: 'same-origin',
                headers: {
                    'Content-Type': 'application/json'
                },
                redirect: 'follow',
                referrerPolicy: 'no-referrer'
            });
        } else {
            return fetch('/v1' + resource, {
                method: method,
                mode: 'cors',
                cache: 'no-cache',
                credentials: 'same-origin',
                headers: {
                    'Content-Type': 'application/json'
                },
                redirect: 'follow',
                referrerPolicy: 'no-referrer',
                body: JSON.stringify(data)
            });
        }
    }
}