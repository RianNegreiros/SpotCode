import React from 'react'
import SectionWrapper from '../../components/common/section_wrapper'
import { Heading } from 'react-bulma-components'
import Search from '../../components/search'
import NavbarFooter from '../../components/common/navbar_footer'

export default function SearchScreen() {
  return (
    <>
      <SectionWrapper>
        <Heading className='has-text-centered has-text-white'>Search</Heading>
        <Search />
      </SectionWrapper>
      <NavbarFooter />
    </>
  )
}