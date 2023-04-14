import React, { useState } from "react"
import { FaRegHeart, FaHeart } from "react-icons/fa"
import FavoritesService from '../../../services/favorites'

export default function Favorite(props) {
  const [favored, setFavored] = useState(props.favored)

  let FavoredButton
  if (favored)
    FavoredButton = <FaHeart size='25px' className='has-text-white' onClick={() => disfavor()} />
  else
    FavoredButton = <FaRegHeart size='25px' className='has-text-white' onClick={() => favor()} />

  async function disfavor() {
    await FavoritesService.delete(props.kind, props.id)
    setFavored(false)
  }

  async function favor() {
    await FavoritesService.create(props.kind, props.id)
    setFavored(true)
  }
  return (
    { FavoredButton }
  )
}