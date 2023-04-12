class Category < ApplicationRecord
  has_many :albums, dependent: :destroy

  validates :name, presence: true

  has_one_attached :image
end
