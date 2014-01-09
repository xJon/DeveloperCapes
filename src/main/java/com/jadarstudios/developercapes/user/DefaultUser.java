/**
 * DeveloperCapes by Jadar
 * License: MIT License
 * (https://raw.github.com/jadar/DeveloperCapes/master/LICENSE)
 * version 3.3.0.0
 */
package com.jadarstudios.developercapes.user;

import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;

import com.jadarstudios.developercapes.HDImageBuffer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DefaultUser implements IUser
{
    
    public final String      username;
    private ITextureObject   texture;
    private ResourceLocation resource;
    
    public DefaultUser(final String name)
    {
        this(name, "");
    }
    
    public DefaultUser(final String name, final String capeUrl)
    {
        this.username = name;
        this.resource = new ResourceLocation("cloaks/" + name);
        this.texture = new ThreadDownloadImageData(capeUrl, null, new HDImageBuffer());
    }
    
    @Override
    public ResourceLocation getResource()
    {
        return this.resource;
    }
    
    @Override
    public ITextureObject getTexture()
    {
        return this.texture;
    }
}
