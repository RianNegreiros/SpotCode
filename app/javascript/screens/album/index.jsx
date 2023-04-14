import React from 'react'
import NavbarFooter from '../../components/common/navbar_footer'
import Albums from '../../components/albums'
import SectionWraper from '../../components/common/section_wrapper'

export default function AlbumScreen() {
  return (
    <>
      <SectionWraper>
        <Albums />
      </SectionWraper>
      <NavbarFooter />
    </>
  )
}