import React, { useState, useEffect } from 'react'
import FavoritesService from '../../services/favorites'
import ResultsTabs from '../common/results_tabs'

export default function Favorites() {
  const [favorites, setFavorites] = useState({})

  async function fetchFavorites() {
    const response = await FavoritesService.index()
    await setFavorites(response.data)
  }

  useEffect(() => {
    fetchFavorites()
  }, [])

  return (
    <>
      <ResultsTabs albums={favorites.albums || []} artists={favorites.artists || []} songs={favorites.songs || []} />
    </>
  )
}