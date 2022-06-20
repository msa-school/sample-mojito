
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import AttireRecommendationManager from "./components/AttireRecommendationManager"

import ActivityRecommendationManager from "./components/ActivityRecommendationManager"

import FoodRecommendationManager from "./components/FoodRecommendationManager"

import UserManager from "./components/UserManager"

import PersonalizedRecommendation from "./components/PersonalizedRecommendation"
import WeatherManager from "./components/WeatherManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/attireRecommendations',
                name: 'AttireRecommendationManager',
                component: AttireRecommendationManager
            },

            {
                path: '/activityRecommendations',
                name: 'ActivityRecommendationManager',
                component: ActivityRecommendationManager
            },

            {
                path: '/foodRecommendations',
                name: 'FoodRecommendationManager',
                component: FoodRecommendationManager
            },

            {
                path: '/users',
                name: 'UserManager',
                component: UserManager
            },

            {
                path: '/personalizedRecommendations',
                name: 'PersonalizedRecommendation',
                component: PersonalizedRecommendation
            },
            {
                path: '/weathers',
                name: 'WeatherManager',
                component: WeatherManager
            },



    ]
})
