Rails.application.routes.draw do
  devise_for :users
  get 'home/index'
  root 'home#index'

  namespace :api, defaults: { format: :json } do
    namespace :v1 do
      resources :dashboard, only: [:index]
      resources :categories, only: [:index, :show]
      resources :search, only: [:index]
      resources :albums, only: [:show]
    end
  end
end
