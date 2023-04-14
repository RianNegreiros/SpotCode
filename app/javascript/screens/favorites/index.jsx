import React from 'react'
import NavbarFooter from '../../components/common/navbar_footer'
import SectionWrapper from '../../components/common/section_wrapper'
import { Heading } from 'react-bulma-components'
import Favorites from '../../components/favorites'

export default function FavoritesScreen() {
  return (
    <>
      <SectionWrapper>
        <Heading className='has-text-centered has-text-white'>Favoritos</Heading>
        <Favorites />
      </SectionWrapper>
      <NavbarFooter />
    </>
  )
}