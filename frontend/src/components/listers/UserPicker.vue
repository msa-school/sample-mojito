<template>
    <div>
        <v-list two-line v-if="value.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    mandatory
                    color="indigo"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in value" :key="idx">
                    <v-list-item-avatar color="grey darken-1"></v-list-item-avatar>
                    
                    <v-list-item-content>
                        <v-list-item-title>{{idx+1}}</v-list-item-title>
                        <v-list-item-subtitle>
                            Id :  {{item.id }} * 
                            Address :  {{item.address }} * 
                            City :  {{item.city }} * 
                        </v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'UserPicker',
        props: {
            user: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            value: [],
            selected: {},
        }),
        async created() {
            var temp = await axios.get(axios.fixUrl('/users'))
            if(temp.data)
                this.value = temp.data._embedded.users;
            if(this.user) {
                this.selected = this.user;
            }
        },
        methods: {
            select(val) {
                this.$emit('selected', this.value[val]);
            },
        },
    };
</script>


<style>
</style>
