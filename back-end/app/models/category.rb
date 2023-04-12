class Category < ApplicationRecord
  has_many :albums, dependent: :destroy

  validates :name, presence: true

  has_one_attached :image

  def artists
    Artist.joins(:albums).where(albums: { category_id: id }).distinct
  end

  def songs
    Song.joins(:album).where(albums: { category_id: id }).distinct
  end
end
