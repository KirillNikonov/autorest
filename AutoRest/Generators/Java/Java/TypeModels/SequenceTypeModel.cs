﻿using Microsoft.Rest.Generator.ClientModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Rest.Generator.Java.TemplateModels;
using Microsoft.Rest.Generator.Utilities;

namespace Microsoft.Rest.Generator.Java
{
    public class SequenceTypeModel : SequenceType, ITypeModel
    {
        public SequenceTypeModel(SequenceType sequenceType)
            : base()
        {
            this.LoadFrom(sequenceType);
        }

        public SequenceTypeModel()
            : base()
        {
        }

        public ITypeModel ElementTypeModel
        {
            get
            {
                return (ITypeModel) this.ElementType;
            }
        }

        public ITypeModel ParameterVariant
        {
            get
            {
                if (ElementTypeModel.ParameterVariant != ElementTypeModel)
                {
                    return new SequenceTypeModel(new SequenceType()
                    {
                        NameFormat = "List<{0}>",
                        ElementType = ElementTypeModel.ParameterVariant
                    });
                }
                return this;
            }
        }

        public ITypeModel ResponseVariant
        {
            get
            {
                if (ElementTypeModel.ResponseVariant != ElementTypeModel)
                {
                    return new SequenceTypeModel(new SequenceType()
                    {
                        NameFormat = "List<{0}>",
                        ElementType = ElementTypeModel.ResponseVariant
                    });
                }
                return this;
            }
        }

        public string DefaultValue(Method method)
        {
            return "null";
        }

        public IEnumerable<string> Imports
        {
            get
            {
                List<string> imports = new List<string> { "java.util.List" };
                return imports.Concat(((ITypeModel) this.ElementType).Imports);
            }
        }

        public ITypeModel InstanceType()
        {
            return this;
        }
    }
}
